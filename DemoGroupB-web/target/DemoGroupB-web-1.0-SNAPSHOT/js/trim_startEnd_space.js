//This js page for trim white space at starting and end in form input field.//
/*******************************************************************************/

//This is for createAdmin.xhtml and createbranch.xhtml page.
$(document).ready(function() {
    $('.trim').change(function() {
        $(this).val(jQuery.trim($(this).val()));
    });
});


