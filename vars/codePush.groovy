import jenkins.model.*
jenkins = Jenkins.instance
import hudson.plugin.git.extension.impl.*
  
  @NonCPS
  codePush(String data){
    def jsonSlurper = new JsonSlurper() 
    def resultJson = jsonSlurper.parseText(data)
   // def projectName = '"'+resultJson.name+'"'
    def gitUrl= resultJson.url
    
    echo gitUrl
  
  def link1 = "rm -rf ./* && git clone https://github.com/amanchourasia/JenkinsWar.git"
  def link2 = "git clone http://rig:${rig_password}@${BB_URL}/scm/DEM/app.git"
  def link3 = "cp -r ./JenkinsWar/* ./app"
  def link4 = "pwd && cd app && pwd && git init && git add --all && git status && git commit -m 'commit' && git push -u origin master"
  
   echo "************** Aman Repo ************"
   
   sh(link1)
   sh(link2)
   sh(link3)
   sh(link4)
    
  }

         
 def call(){
 def request = libraryResource 'data.json'
 codePush(request)
 }               
   
