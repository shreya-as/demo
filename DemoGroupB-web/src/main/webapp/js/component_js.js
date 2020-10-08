/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


function handleDisableButton(data, id, bgId) {
    jQuery.noConflict();
    var button = null;
    var bgDisplay = null;

    button = document.getElementById(id);
    if (bgId != null) {
        bgDisplay = document.getElementById(bgId);
    }


    switch (data.status) {
        case "begin"://This is called right bfore ajax request is been sent.
            //alert("Begin State");
            jQuery.blockUI({css: {
                    border: 'none',
                    padding: '15px',
                    backgroundColor: '#000',
                    '-webkit-border-radius': '10px',
                    '-moz-border-radius': '10px',
                    opacity: .6,
                    color: '#fff'
                }});

            button.disabled = true;
            if (bgDisplay != null) {
                bgDisplay.style.display = 'block';
            }

            break;

        case "complete"://This is called right after ajax request is received
            //we don't want to enable it yet right here,right
            //alert("Ajax response is complete but don't want to enable the button");
            break;

        case "success":
            //alert("success state");
            //alert("Enabling the button");
            if (bgDisplay != null) {
                bgDisplay.style.display = 'none';
            }
            setTimeout(jQuery.unblockUI, 0);
            button.disabled = false;
            break;
    }
}


//Handling double click in menu items and command link
var commandLinkId = "";
function gettingComponentId(componentId) {
    commandLinkId = componentId;
}
function handleDisableLink(data) {
    switch (data.status) {
        case "begin":
            document.getElementById(commandLinkId).style.cursor = 'default';
            document.getElementById(commandLinkId).style.pointerEvents = 'none';
            break;
        case "complete":
            document.getElementById(commandLinkId).style.cursor = 'pointer';
            document.getElementById(commandLinkId).style.pointerEvents = 'visible';
            break;
    }
}

function showJqueryLoader(data) {
    jQuery.noConflict();
    switch (data.status) {
        case "begin"://This is called right bfore ajax request is been sent.
            jQuery.blockUI({css: {
                    border: 'none',
                    padding: '15px',
                    backgroundColor: '#000',
                    '-webkit-border-radius': '10px',
                    '-moz-border-radius': '10px',
                    opacity: .6,
                    color: '#fff'
                }});

            break;

        case "complete":
            break;

        case "success":
            setTimeout(jQuery.unblockUI, 0);
            break;
    }
}

//use in funtransfer,billpayment and other payment transaction
function handleTransferButton(data) {
    switch (data.status) {
        case "begin"://This is called right bfore ajax request is been sent.
            jQuery.blockUI({css: {
                    border: 'none',
                    padding: '15px',
                    backgroundColor: '#000',
                    '-webkit-border-radius': '10px',
                    '-moz-border-radius': '10px',
                    opacity: .6,
                    color: '#fff'
                }});

            break;

        case "complete":
            break;

        case "success":
            setTimeout(jQuery.unblockUI, 0);
            break;
    }

    function displayBg(data, bgId) {
        var bgDisplay = null;
        if (bgId != null) {
            bgDisplay = document.getElementById(bgId);
        }


        switch (data.status) {
            case "begin"://This is called right bfore ajax request is been sent.
                if (bgDisplay != null) {
                    bgDisplay.style.display = 'block';
                }

                break;

            case "complete"://This is called right after ajax request is received
                //we don't want to enable it yet right here,right
                break;

            case "success":
                //alert("success state");
                //alert("Enabling the button");
                if (bgDisplay != null) {
                    bgDisplay.style.display = 'none';
                }
//        button.disabled= false;
                break;
        }
    }

}
