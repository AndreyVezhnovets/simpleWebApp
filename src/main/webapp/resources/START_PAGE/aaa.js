function aaa(c) {

    $.ajax({
        url: '/answerNumber',
        data: 'answerNumber='+c,

        success: function (html) {
            $('#1').html(html);
        }
    });    
}