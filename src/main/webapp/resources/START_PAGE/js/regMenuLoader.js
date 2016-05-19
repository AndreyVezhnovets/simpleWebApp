function regMenuLoader() {
    $.ajax({
        url: '/regLoader',
      success: function (html) {
            $('#regMenu').html(html);
        }
    });
}