jQuery.noConflict()(function($){

/* ===============================================
   Woocommerce Header Cart
   ============================================= */

	$('section.header-cart').hover(
		
		function () {
			$(this).children('div.header-cart-widget').stop(true, true).fadeIn(100);
		}, 
		function () {
			$(this).children('div.header-cart-widget').stop(true, true).fadeOut(400);		
		}
			
	);

/* ===============================================
   Footer
   =============================================== */

	function wip_footer() {
	
		var footer_h = $('#bottom_area').innerHeight();
		$('#wrapper').css({'padding-bottom':footer_h});
	
	}
	
	$( document ).ready(wip_footer);
	$( window ).resize(wip_footer);

/* ===============================================
   Mobile menu with Tinynav Plugin
   =============================================== */
	
	if ( $('nav#mainmenu ul:first .current-menu-item').length ) { 
	
		$('nav#mainmenu ul:first').tinyNav({
			active: 'current-menu-item',
		});

	} else {
	
		$('nav#mainmenu ul:first').tinyNav({
			header: 'Select an item',
		});

	}

/* ===============================================
   Scroll to Top Plugin
   =============================================== */

	$(window).scroll(function() {
		if( $(window).scrollTop() > 500 ) {
			$('#back-to-top').fadeIn(500);
				} else {
			$('#back-to-top').fadeOut(500);
		}
	});

	$('#back-to-top').click(function(){
		$.scrollTo(0,'slow');
		return false;
	});


/* ===============================================
   Portfolio code
   =============================================== */

	$('.filterable-grid li').live('mouseover',function(){
			
		var imgw = $('.overlay',this).prev().width();
		var imgh = $('.overlay',this).prev().height();
			
		$('.overlay',this).css({'width':imgw,'height':imgh});	
			
		$('.overlay',this).animate({ opacity : 0.6 },{queue:false});
	
	});

	$('.filterable-grid li').live('mouseout',function(){
		
		$('.overlay', this).animate({ opacity: 0}, { queue:false });
		
	});

	$('.skills .views').click(function(){
	
	if($(this).next('ul').css('display')=='none') {	
			$(this).addClass('active');
			$('.skills .views i').addClass('open');
		}
	else {	
			$(this).removeClass('active');
			$('.skills .views i').removeClass('open');
		}
				
			$(this).next('ul').stop(true,false).slideToggle('hight');

	});

/* ===============================================
   Contact form code
   =============================================== */

	$(".contact-form .buttons").click(function() {
		
		var hasError = false;
	
		var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
			
		if ($("input#contact-name").val() === '') {
			hasError = true;
		}
		
		if ($("input#contact-subject").val() === '') {
			hasError = true;
		}
		
		if ($("#contact-message").val() === '') {
			hasError = true;
		}
		
		if ( !emailReg.test( $("#contact-email").val() ) || $("#contact-email").val() === '' ) {
			hasError = true;
		}
	
		if(hasError === true) {
			$('span.error').css({'display':'block'});
			return false;
	
		} else {
			$('span.error').css({'display':'none'});
			return true;
		}
	
	});

/* ===============================================
   Menu code
   =============================================== */

	$('nav#mainmenu li').hover(
	
		function () {
			$(this).children('ul').stop(true, true).fadeIn(100);
	 
		}, 
		function () {
			$(this).children('ul').stop(true, true).fadeOut(400);		
		}
	
	);

	$('nav#mainmenu ul > li').each(function(){
    	if( $('ul', this).length > 0 )
        $(this).children('a').append('<span class="sf-sub-indicator"> <i class="fa fa-angle-down"></i> </span>');
	}); 

	$('nav#widgetmenu ul > li').each(function(){
    	if( $('ul', this).length > 0 )
        $(this).children('a').append('<span class="sf-sub-indicator"> &raquo;</span>').removeAttr("href");
	}); 

	$('nav#widgetmenu ul > li ul').click(function(e){
		e.stopPropagation();
    })
	
    .filter(':not(:first)')
    .hide();
    
	$('nav#widgetmenu ul > li, nav#widgetmenu ul > li > ul > li').click(function(){

		var selfClick = $(this).find('ul:first').is(':visible');
		if(!selfClick) {
		  $(this).parent().find('> li ul:visible').slideToggle('low');
		  
		
		}
		
		$(this).find('ul:first').stop(true, true).slideToggle();
	
	});

/* ===============================================
   Tabs code
   =============================================== */

	$( ".tabs" ).tabs({ hide: { effect: "fadeOut", duration: 300 } });
	
/* ===============================================
   Toggle code
   =============================================== */
	
	$('.toggle_container h5.element').last().css('border-bottom', 'none' , 'border-top', 'none');
	$('.toggle_container h5.element').click(function(){		
		if($(this).next('.toggle').css('display')=='none') {	
				$(this).addClass('inactive');
				$(this).children('i').addClass('open');
			}
		else {	$(this).removeClass('inactive');
				$(this).children('img').removeClass('inactive');
				$(this).children('i').removeClass('open');
			}
					
				$(this).next('.toggle').stop(true,false).slideToggle('slow');
	
		});

/* ===============================================
   Overlay code
   =============================================== */
	
	$('.overlay-image.shortcode-thumb').hover(function(){
		
		var imgwidth = $(this).children('img').width();
		var imgheight = $(this).children('img').height();
		$(this).children('.zoom').css({'width':imgwidth,'height':imgheight});	
		$(this).children('.link').css({'width':imgwidth,'height':imgheight});		
		$(this).css({'width':imgwidth+10});		
		
		$('.overlay',this).animate({ opacity : 0.6 },{queue:false});
		}, 
		function() {
		$('.overlay',this).animate({ opacity: 0.0 },{queue:false});
	
	});
	
	$('.overlay-image.blog-thumb').hover(function(){
		
		var imgwidth = $(this).children('img').width();
		var imgheight = $(this).children('img').height();
		$(this).children('.link').css({'width':imgwidth,'height':imgheight});		
		$(this).css({'width':imgwidth});		
		
		$('.overlay',this).animate({ opacity : 0.4 },{queue:false});
		}, 
		function() {
		$('.overlay',this).animate({ opacity: 0.0 },{queue:false});
	
	});

	$('.gallery img').hover(function(){
		$(this).animate({ opacity: 0.50 },{queue:false});
	}, 
	function() {
		$(this).animate({ opacity: 1.00 },{queue:false});
	});
	
/* ===============================================
   Prettyphoto code
   =============================================== */

	$("a[data-rel^='prettyPhoto']").prettyPhoto({
	
		animationSpeed:'fast',
		slideshow:5000,
		theme:'pp_default',
		show_title:false,
		overlay_gallery: false,
		social_tools: false
	
	});

/* ===============================================
   MASONRY
   =============================================== */

	function wip_masonry() {

		if ( $(window).width() >= 992 ) {

			$('.masonry').imagesLoaded(function () {

				$('.masonry').masonry({
					itemSelector: '.masonry-item',
					isAnimated: true
				});

			});
	
		} else {

			$('.masonry').imagesLoaded(function () {

				$('.masonry').masonry( 'destroy' );

			});

		}
	
	}
					
	$(window).resize(function(){
		wip_masonry();
	});
						
	$(document).ready(function(){
		wip_masonry();
	});

/* ===============================================
   FLEX SLIDER
   =============================================== */

	$('.flexslider').flexslider({
		
		animation : $('.slider-flexslider').attr('data-effect'),
		direction : $('.slider-flexslider').attr('data-direction'),
		slideshowSpeed : $('.slider-flexslider').attr('data-slidespeed'),
		animationSpeed : $('.slider-flexslider').attr('data-animationspeed'),    
		controlNav: false,
		smoothHeight: true,
		keyboardNav: false,
		prevText: "&lt;",
		nextText: "&gt;",
		touch: true,

		after: function(){
			wip_masonry();
		}
		
	});

});          