/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


function handleDisableCheckbox(data,id) {    

    var table = document.getElementById(id);

    var tableInputTags = table.getElementsByTagName("input");
    var numberOfCheckBoxes = tableInputTags.length;

    switch(data.status){
        case "begin":
        for(var i =0;i<numberOfCheckBoxes;i++){
            document.getElementById(tableInputTags[i].id).disabled=true;        
            }
            break;

        case "complete":
            break;

        case "success":
        for(var i =0;i<numberOfCheckBoxes;i++){
            document.getElementById(tableInputTags[i].id).disabled=false;        
            }
            break;
    }




}
