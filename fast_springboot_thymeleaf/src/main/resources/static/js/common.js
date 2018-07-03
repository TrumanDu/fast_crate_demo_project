/**
 * 重置
 */
function formReset(){
	$('.search-form :input')
	.not(':button,:submit,:reset,:hidden')   //将myform表单中input元素type为button、submit、reset、hidden排除
    .val('')  //将input元素的value设为空值
    .removeAttr('checked')
    .removeAttr('selected') // 如果任何radio/checkbox/select inputs有checked or selected 属性，将其移除;
}
/**
 * 查询
 */
function search(){
	$.ajax({
		type: 'post',
		url: webRoot+$('.search form').attr('action'),
		data: $('.search form').serialize(),
		dataType: 'html',
		success: function(data){
			$(".panel-content").html(data);
		}
	});
}

/**
 * 分页查询
 * @param pageNo 页码
 */
function page(pageNo){
	var url = $('.search-form').attr('action');
	if(url.indexOf('?') > -1){
		url += '&pageNo=' + pageNo;
	}
	else{
		url += '?pageNo=' + pageNo;
	}
	$.ajax({
		type: 'post',
		url: webRoot+url,
		data: $('.search-form').serialize(),
		dataType: 'html',
		success: function(data){
			$("body").html(data);
		}
	});
}