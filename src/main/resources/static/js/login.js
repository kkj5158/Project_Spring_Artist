
$(document).ready(function () {
    $(document).on("click", "#signin", function () {
        $('.pinkbox').css('transform', 'translateX(0%)');
        $('.signup').addClass('nodisplay');
        $('.signin').removeClass('nodisplay');
    });
});

$(document).ready(function () {
    $(document).on("click", "#signup", function () {
        $('.pinkbox').css('transform', 'translateX(80%)');
        $('.signin').addClass('nodisplay');
        $('.signup').removeClass('nodisplay');
    });
});

