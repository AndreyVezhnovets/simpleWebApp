function jjj(i) {
    
    $.ajax({
        url: '/123',
        data: 'newsNumber='+(1+i),

        success: function (html) {
            $('#1').html(html);
        }
    });
    $.ajax({
        url: '/123',
        data: 'newsNumber='+(2+i),

        success: function (html) {
            $('#2').html(html);
        }
    });
    $.ajax({
        url: '/123',
        data: 'newsNumber='+(3+i),

        success: function (html) {
            $('#3').html(html);
        }
    });

    $.ajax({
        url: '/123',
        data: 'newsNumber='+(4+i),

        success: function (html) {
            $('#4').html(html);
        }
    });
}