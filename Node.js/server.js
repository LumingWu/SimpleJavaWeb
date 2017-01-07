var http = require("http"),
	port = 8080;

var url = require("url");

var querystring = require("querystring");

var fs = require("fs");

function geterrorpage(response, errorcode){
	response.writeHead(200, {"Content-Type": "text/html"});
	try{
		response.write(fs.readFileSync("error.html", "utf8"));
	} catch(ex){
		callaback(ex);
		console.error("Attempt: Read file error.html");
		response.write("Server Internal Error: It will be fixed by a intelligent bonobo");
	}
}

function getpage(response, path){
	response.writeHead(200, {"Content-Type": "text/html"});
	try{
		response.write(fs.readFileSync(path, "utf8"));
	} catch(ex){
		callback(ex);
		console.error("Attemp: Read file " + path);
		geterrorpage(response, "404");
	}
}

http.createServer( (request, response) => {
	var requesturl = url.parse(request.url);
	switch(request.method){
		case "GET":
			switch(requesturl.path){
				case "/":
					getpage(response, "index.html");
					break;
				default:
					geterrorpage(response, "404");
					break;
			}
			break;
		case "POST":
			break;
		case "PUT":
			break;
		case "DELETE":
			break;
		default:
			geterrorpage(response, "405");
	}
	response.end();
}).listen(port);

