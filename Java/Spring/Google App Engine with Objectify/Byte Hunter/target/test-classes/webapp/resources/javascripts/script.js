/*
var username = "<key>";
var password = "<password>";

var url = "https://text.s4.ontotext.com/v1/news";
var method = "POST";


var inputString = "<text goes here>";

var postData = {
    "document": inputString,
    "documentType": "text/plain"
};

var dataString = JSON.stringify(postData);

var xhr = new XMLHttpRequest();
xhr.open(method, url, true);
xhr.withCredentials = true;
xhr.setRequestHeader("Authorization", "Basic " + btoa(username + ":" + password));
xhr.setRequestHeader("Accept", "application/json");
xhr.setRequestHeader("Content-Type", "application/json");
xhr.onreadystatechange=function() {
    if (xhr.readyState == 4) {
        if(xhr.status == 200) {
            var obj = JSON.parse(xhr.responseText);


        }
    }
};
xhr.send(dataString);
*/