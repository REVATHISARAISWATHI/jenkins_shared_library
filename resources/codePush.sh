#!/usr/bin/bash

git clone https://github.com/amanchourasia/JenkinsWar.git
git clone http://{rig}:{rigaDapt@devOps}@18.224.68.30:7990/scm/DEM/app.git
cp -r ./JenkinsWar/* ./app
cd app
git init
git add --all
git commit -m"initial commit"
git push -u origin master
