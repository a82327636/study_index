package com.study.common.util;

import java.io.Serializable;

/**
 * 分页对象
 * 
 * @version V1.0
 * @author yhq [unicorn668@163.com] 创建时间：2012-11-2 上午11:27:12
 */
public class Page implements Serializable {
	private static final long serialVersionUID = 1L;
	private static Integer[]pages = { 10, 20, 30, 50, 100 };
	
	/*	
	 * 翻页导航控件使用说明：
	 * 1.pageStr 与 pageSubStr 区别： 
	 * 	  主翻页导航pageStr,包括翻页内容、隐藏变量及调用脚本;
	 *   副翻页导航pageSubStr,仅包含翻页内容，需依赖于主翻页的隐藏变量及脚本才能使用;
	 * 2. 单个翻页调用：主翻页导航 page.pageStr
	 * 3. 两个翻页导航同时调用：
	 * 	   主翻页导航 page.pageStr;
	 *   副翻页导航page.pageSubStr;
	 * 4. ajaxPageStr ajax 获取jsp后，进行局部分页
	 * 
	 * 翻页导航控件内容 见Div内：
	 * <div class="page">
	 *  <ul>
	 *     <li class="page1"><span>首页</span><span><a href="">上页</a></span><span><a href="">下页</a></span><span><a href="">尾页</a></span></li>
	 *     <li class="page2">
	 *         <select><option>20</option></select> 条/页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	 *         <input type="text" class="page_number"/> /26页 <a href="" class="page_link">跳转</a> 
	 *         	共 <span><b>26</b></span> 条
	 *     </li>
	 *  </ul>
	 * </div>
	*/
	private int showCount=10; // 每页显示记录数
	private int totalPage; // 总页数
	private int totalResult; // 总记录数
	private int currentPage; // 当前页
	private int currentResult; // 当前记录起始索引
	private String pageStr; // 最终页面显示的底部翻页导航，详细见：getPageStr();
	private String pageSubStr;
	private String ajaxPageStr;
	
	public int getTotalPage() {
		if (totalResult % showCount == 0)
			totalPage = totalResult / showCount;
		else
			totalPage = totalResult / showCount + 1;
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalResult() {
		return totalResult;
	}

	public void setTotalResult(int totalResult) {
		this.totalResult = totalResult;
	}

	public int getCurrentPage() {
		if (currentPage <= 0)
			currentPage = 1;
		if (currentPage > getTotalPage())
			currentPage = getTotalPage();
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getShowCount() {
		return showCount;
	}

	public void setShowCount(int showCount) {
		this.showCount = showCount;
	}

	public int getCurrentResult() {
		currentResult = (getCurrentPage() - 1) * getShowCount();
		if (currentResult < 0)
			currentResult = 0;
		return currentResult;
	}

	public void setCurrentResult(int currentResult) {
		this.currentResult = currentResult;
	}
	
	public String getPageStr() {
		pageStr = "";
		if (totalResult > 0) {
			pageStr =  getPageContent() + getPageScripts();
		}
		
		return pageStr;
	}

	public void setPageStr(String pageStr) {
		this.pageStr = pageStr;
	}

	public String getPageSubStr() {
		pageSubStr = "&nbsp;";
		if (totalResult > 0) {
			pageSubStr =  getPageContent();
		}
		
		return pageSubStr;
	}

	public void setPageSubStr(String pageSubStr) {
		this.pageSubStr = pageSubStr;
	}
	
	
	public String getAjaxPageStr() {
		ajaxPageStr = "";
		if (totalResult > 0) {
			ajaxPageStr =  getAjaxPageContent() + getAjaxPageScripts();
		}
		return ajaxPageStr;
	}

	public void setAjaxPageStr(String ajaxPageStr) {
		this.ajaxPageStr = ajaxPageStr;
	}

	/**
	 * 取得分页页面内容
	 * @return 
	 * @create  2013-10-25 下午02:30:53 haoqj
	 * @history
	 */
	private String getPageContentOld() {
		StringBuffer sb = new StringBuffer();
		sb.append("	<ul><li class=\"page1\">");
		if (currentPage == 1) {
			sb.append("<span>首页</span>");
			sb.append("<span>上页</span>");
		} else {
			sb.append("<span><a href=\"###\" onclick=\"nextPage(1)\">首页</a></span>");
			sb.append("<span><a href=\"###\" onclick=\"nextPage(" + (currentPage - 1) + ")\">上页</a></span>");
		}
		if (currentPage == totalPage) {
			sb.append("<span>下页</span>");
			sb.append("<span>尾页</span>");
		} else {
			sb.append("<span><a href=\"###\" onclick=\"nextPage(" + (currentPage + 1) + ")\">下页</a></span>");
			sb.append("<span><a href=\"###\" onclick=\"nextPage(" + totalPage + ")\">尾页</a></span>");
		}
		sb.append("</li><li class=\"page2\">");
		sb.append("<select onchange=\"return selectSubmit(this);\" >");
		for(int opt: pages){
			sb.append("<option value=\""+opt+"\" "+ (opt == showCount?"selected":"")+">"+opt+"</option>");
		}
		sb.append("</select>&nbsp;条/页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		sb.append("<input type=\"text\"class=\"page_number\" maxlength=\"5\" onchange=\"return inputSubmit(this);\" onkeydown=\"if(event.keyCode==13){return inputSubmit(this);}\" value=" + currentPage + "></input>");
		sb.append("&nbsp;/&nbsp;<b>" + totalPage + "</b>&nbsp;页");
		sb.append("&nbsp;&nbsp;共&nbsp;<span><b>" + totalResult + "</b></span>&nbsp;条&nbsp;");
		sb.append("</ul>\n");

		return sb.toString();
	}

	private String getPageContent() {
		StringBuffer sb = new StringBuffer();
	/*	<div class="com-page fl_r">
		<a href="javascript:;">首页</a>
		<a href="javascript:;" class="no">上页</a>
		<input type="text" value="1" class="pa" /><label>/2</label>
		<a href="javascript:;">下页</a>
		<a href="javascript:;">尾页</a>
		<select>
		<option value="10">10</option>
		<option value="20">20</option>
		<option value="30">30</option>
		</select>
		<label>条/页</label>
		</div>*/


		sb.append("<div class=\"com-page fl_r\">");
		if (currentPage == 1) {
			sb.append("<a href=\"###\" class=\"no\">首页</a>");
			sb.append("<a href=\"###\" class=\"no\">上页</a>");
		} else {
			sb.append("<a href=\"javascript:nextPage(1)\">首页</a>");
			sb.append("<a href=\"javascript:nextPage(" + (currentPage - 1) + ")\">上页</a>");
		}

		sb.append("<input type=\"text\"class=\"pa\" maxlength=\"5\" onchange=\"return inputSubmit(this);\" onkeydown=\"if(event.keyCode==13){return inputSubmit(this);}\" value=\"" + currentPage + "\">");
		sb.append("<label>/" + totalPage + "</label>");


		if (currentPage == totalPage) {
			sb.append("<a href=\"###\" class=\"no\">下页</a>");
			sb.append("<a href=\"###\" class=\"no\">尾页</a>");
		} else {
			sb.append("<a href=\"javascript:nextPage(" + (currentPage + 1) + ")\">下页</a>");
			sb.append("<a href=\"javascript:nextPage(" + totalPage + ")\">尾页</a>");
		}
		sb.append("<select onchange=\"return selectSubmit(this);\" >");
		for(int opt: pages){
			sb.append("<option value=\""+opt+"\" "+ (opt == showCount?"selected":"")+">"+opt+"</option>");
		}
		sb.append("</select>");
		sb.append("<label>条/页</label>");
		sb.append("&nbsp;&nbsp;共&nbsp;<span><b>" + totalResult + "</b></span>&nbsp;条&nbsp;");
		sb.append("</div>\n");

		return sb.toString();
	}




	
	/** 
	 * 取得分页隐藏变量及JS脚本
	 * @return 
	 * @create  2013-10-25 下午02:31:51 haoqj
	 * @history  
	 */
	private String getPageScripts() {
		StringBuffer sb = new StringBuffer();
		sb.append("<input type=\"hidden\"  id=\"page.showCount\" name=\"page.showCount\" value=" + showCount + "></input>");
		sb.append("<input type=\"hidden\"  id=\"page.currentPage\" name=\"page.currentPage\" value=" + currentPage + "></input>");
		sb.append("<input type=\"hidden\"  id=\"page.totalResult\" name=\"page.totalResult\" value=" + totalResult + "></input>");
		sb.append("<script type=\"text/javascript\">\n");
		sb.append("function nextPage(val){ \n");
		sb.append("  document.getElementById(\"page.currentPage\").value=val;\n");
		sb.append("  document.forms[0].submit();\n");
		sb.append("} \n");
		sb.append("function selectSubmit(obj){ \n");
		sb.append("  document.getElementById(\"page.showCount\").value=obj.value;\n");
		sb.append("  document.forms[0].submit();\n");
		sb.append("} \n");
		sb.append("function inputSubmit(obj){ \n");
		sb.append("		var va = obj.value; \n");
		sb.append("  	if(va==\"\"||isNaN(va)){ \n");
		sb.append("  		alert('请输入数字!');\n");
		sb.append("  		obj.value=" + currentPage + ";\n");
		sb.append("  		return false;\n");
		sb.append("  	}else if(va > " +totalPage+ " || va < 1){ \n");
		sb.append("  		alert('输入页码不存在！');\n");
		sb.append("  		obj.value=" + currentPage + ";\n");
		sb.append("  		return false;\n");
		sb.append("  	}\n");
		sb.append("  	document.getElementById(\"page.currentPage\").value=va;\n");
		sb.append("     document.forms[0].submit();\n");
		sb.append("} \n");
		sb.append("</script>\n");
		return sb.toString();
	}
	
	/** ajax 局部分页 js方法 */
	private String getAjaxPageScripts() {
		StringBuffer sb = new StringBuffer();
		sb.append("<input type=\"hidden\"  id=\"page.showCount\" name=\"page.showCount\" value=" + showCount + "></input>");
		sb.append("<input type=\"hidden\"  id=\"page.currentPage\" name=\"page.currentPage\" value=" + currentPage + "></input>");
		sb.append("<input type=\"hidden\"  id=\"page.totalResult\" name=\"page.totalResult\" value=" + totalResult + "></input>");
		sb.append("<script type=\"text/javascript\">\n");
		sb.append("function nextPage(val){ \n");
		sb.append("  document.getElementById(\"page.currentPage\").value=val;\n");
		sb.append(" ajax_Submit();\n");
		sb.append("} \n");
		sb.append("function selectSubmit(obj){ \n");
		sb.append("  document.getElementById(\"page.showCount\").value=obj.value;\n");
		sb.append("  ajax_Submit();\n");
		sb.append("} \n");
		sb.append("function inputSubmit(obj){ \n");
		sb.append("		var va = obj.value; \n");
		sb.append("  	if(va==\"\"||isNaN(va)){ \n");
		sb.append("  		alert('请输入数字!');\n");
		sb.append("  		obj.value=" + currentPage + ";\n");
		sb.append("  		return false;\n");
		sb.append("  	}else if(va > " +totalPage+ " || va < 1){ \n");
		sb.append("  		alert('输入页码不存在！');\n");
		sb.append("  		obj.value=" + currentPage + ";\n");
		sb.append("  		return false;\n");
		sb.append("  	}\n");
		sb.append("  	document.getElementById(\"page.currentPage\").value=va;\n");
		sb.append("     ajax_Submit();\n");
		sb.append("} \n");
		sb.append("</script>\n");
		return sb.toString();
	}
	
	private String getAjaxPageContent() {
		StringBuffer sb = new StringBuffer();
		sb.append("<div class=\"com-page fl_r\">");
		if (currentPage == 1) {
			sb.append("<a href=\"javascript:;\" class=\"no\">首页</a>");
			sb.append("<a href=\"javascript:;\" class=\"no\">上页</a>");
		} else {
			sb.append("<a href=\"#\" onclick=\"nextPage(1)\">首页</a>");
			sb.append("<a href=\"#\" onclick=\"nextPage(" + (currentPage - 1) + ")\">上页</a>");
		}

		sb.append("<input type=\"text\"class=\"pa\" maxlength=\"5\" onchange=\"return inputSubmit(this);\" onkeydown=\"if(event.keyCode==13){return inputSubmit(this);}\" value=\"" + currentPage + "\">");
		sb.append("<label>/" + totalPage + "</label>");


		if (currentPage == totalPage) {
			sb.append("<a href=\"javascript:;\" class=\"no\">下页</a>");
			sb.append("<a href=\"javascript:;\" class=\"no\">尾页</a>");
		} else {
			sb.append("<a href=\"#\" onclick=\"nextPage(" + (currentPage + 1) + ")\">下页</a>");
			sb.append("<a href=\"#\" onclick=\"nextPage(" + totalPage + ")\">尾页</a>");
		}
		sb.append("<select onchange=\"return selectSubmit(this);\" >");
		for(int opt: pages){
			sb.append("<option value=\""+opt+"\" "+ (opt == showCount?"selected":"")+">"+opt+"</option>");
		}
		sb.append("</select>");
		sb.append("<label>条/页</label>");
		sb.append("&nbsp;&nbsp;共&nbsp;<span><b>" + totalResult + "</b></span>&nbsp;条&nbsp;");
		sb.append("</div>\n");

		return sb.toString();
	}

}