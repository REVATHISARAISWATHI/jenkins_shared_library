import groovy.json.JsonSlurper 

@NonCPS
createDevBranch(String data,String data2){
def jsonSlurper = new JsonSlurper() 
def resultJson = jsonSlurper.parseText(data)
//def repoName = '"'+resultJson.repoName+'"'
def projUrl = '"'+resultJson.url+'"'
  
  httpRequest authentication: 'bitbucket_anu', contentType: 'APPLICATION_JSON', customHeaders: [[maskValue: false, name: 'Content-Type', value: 'application/json']], httpMode: 'POST', requestBody: '''
{
    "name": data2,
    "startPoint": "refs/heads/master"
}''', responseHandle: 'NONE', url: resultJson.url+'DEM/repos/web_1/branches' 
}


def call(Stirng text){
 def request = libraryResource 'data.json'
 createDevBranch(request,text)
}



/*def call(String text){
httpRequest authentication: 'bitbucket_anu', contentType: 'APPLICATION_JSON', customHeaders: [[maskValue: false, name: 'Content-Type', value: 'application/json']], httpMode: 'POST', requestBody: '''{
    "name": "DEV",
    "startPoint": "refs/heads/master"
}''', responseHandle: 'NONE', url: 'http://18.224.68.30:7990/rest/api/1.0/projects/DEM/repos/web_1/branches'

}*/
