node {
  // Mark the code checkout 'stage'....
  stage 'Obtaining Source Code From Repository'
    deleteDir()
   checkout([$class: 'GitSCM', branches: [[name: '*/feature_branch']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '9012e5cc-475f-4e1f-959c-4f5997eeae70', url: 'https://github.com/nivimor/eribank-espresso.git']]])
    def commit = ""
    def branchName = "feature_branch"
    if(isUnix()){
        commit = sh(returnStdout: true, script: 'git log -1 --oneline').trim()
    }
    else{
        commit = bat(returnStdout: true, script: 'git log -1 --oneline').trim()
    }

    stage 'Getting the commit message'
        String commitMsg = ""
        println commit
        List commitMsgPre = commit.split(" ")
        for(int i=1; i<commitMsgPre.size(); i++){
            commitMsg += commitMsgPre.getAt(i) + " "
        }

    if(isUnix()){
          sh "echo this is the msg ${commitMsg}"
          sh "echo this the branch ${branchName}"
    }
    else{
         bat "echo this is the msg ${commitMsg}"
         bat "echo this the branch ${branchName}"
    }

  stage 'Building the App'
          if(isUnix()){
            sh "./gradlew assembleDebug"
            sh "sh ./scripts/upload-app.sh"
          }
          else{
            bat "gradlew assembleDebug"
            bat "scripts/upload-app.bat"
          }

  stage 'Running Tests'
      if (isUnix()) {
      //build your gradle flavor, passes the current build number as a parameter to gradle

          parallel('Run appium tests': {
              sh "./gradlew testDebug --tests=tests.TestRunner"
              },
             )
          }
      else {
          parallel('Run appium tests': {
                bat "gradlew testDebug --tests tests.TestRunner"
                },
             )
      }

    stage 'Archiving Artifacts'
    //tell Jenkins to archive the apks
    archiveArtifacts artifacts: 'app/build/outputs/apk/*.apk', fingerprint: true

    stage 'clean'
         if(isUnix()){
              sh "./gradlew clean"
         }
         else{
              bat "gradlew clean"
         }

    stage 'Merging to Master'

    if(isUnix()){
              sh """git checkout ${branchName};
              git checkout master;
              git merge ${branchName};
              git pull origin master
              git push https://${GIT_USERNAME}:${GIT_PASSWORD}@github.com/nivimor/eribank-espresso.git master"""
         }
         else{

              bat(/git checkout master
              git merge origin\/feature_branch
              git commit -am "${commitMsg} and merged to master"
              git push https:\/\/${GIT_USERNAME}:${GIT_PASSWORD}@github.com\/nivimor\/eribank-espresso.git master/)
         }


}
