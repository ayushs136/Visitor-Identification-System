$(document).ready(function(){
	
$.getJSON('FetchStatesJSON',{ajax:true},function(data){
//alert(data);
$('#state').append($('<option>').val('-Select-').text('-Select-'));
$('#city').append($('<option>').val('-Select-').text('-Select-'));
$.each(data,function(i,item){
	$('#state').append($('<option>').val(item.STATEID).text(item.STATENAME));
	
});
 });	
	
$('#state').change(function(){
	$.getJSON('FetchCitiesByStateJSON',{ajax:true,stateid:$('#state').val()},function(data){
		//alert(data);
		$('#city').empty();
		$('#city').append($('<option>').val('-Select-').text('-Select-'));
		$.each(data,function(i,item){
			$('#city').append($('<option>').val(item.CITYID).text(item.CITYNAME));
		});
	});
	
});

});





