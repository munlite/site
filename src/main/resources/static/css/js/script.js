$(function () {
	var el =  $('#slider img'),
		indexImg = 1,
		indexMax = el.length;
		
		function autoCange () {	
			indexImg++;
			if(indexImg > indexMax) {
				indexImg = 1;
			}			
			el.fadeOut(500);
			el.filter(':nth-child('+indexImg+')').fadeIn(500);
		}	
		setInterval(autoCange, 3000);	
});