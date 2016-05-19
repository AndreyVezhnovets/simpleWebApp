function regUdater() {

    $(document).ready(function () {
        var a= $('#app_username').val();
        $.ajax({
            url: '/userName',
            data: 'userName='+a,
            async: false,
            success: function (z) {
                $('#987').html(z);
               
            }

        });

    });
}