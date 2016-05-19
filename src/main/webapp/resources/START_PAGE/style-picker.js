jQuery.noConflict()(function($){

	$(".style-picker .opentab").click(function() {
		if($('div.style-picker').css('left')=='-182px')
			{	
				$('div.style-picker').animate({'left':'0'});
						
			}
		if($('div.style-picker').css('left')=='0px')
			{	
				$('div.style-picker').animate({'left':'-182'});
						
			}
	});
	
		var dir = $('#themedir').val();
		var skins = $('#skins').val();
		
	$('#skins').change(function() {
		
		var skins = jQuery(this).val();
		$("#Custom-css").attr("href", "http://demo.themeinprogress.com/nova/wp-content/themes/nova/assets/skins/"+skins+".css");
		$('#customstyle').html('');
				
		var substr = skins.split('_');
		jQuery('body').removeClass('dark').removeClass('light').addClass(substr[0]);
		
	}); 

	$('#patterns').change(function() {
		
		var skins = $('#skins').val();
		var patterns = $(this).val();
		
		$("#Custom-css").attr("href", "http://demo.themeinprogress.com/nova/wp-content/themes/nova/assets/skins/"+skins+".css");
		$('#customstyle').append( 'body { background-image: url('+dir+patterns+') !important; background-repeat:repeat;}  ');
		
	}); 

});          