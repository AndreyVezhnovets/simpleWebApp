function adminUpdater() {
        $(document).ready(function () {
               $.ajax({
                url: '/userRole',
                async: false,
                success: function (z) {
                    $('#menu-item-2692').replaceWith(z);

                }

            });

        });
    }