# Android Application CI Pipeline

## This repo contains the following:
1. A demo Android app 
2. A simple Appium based test
3. A .yml providing instructions for Travis CI
4. scripts for bundling and uploading the app

### Instructions how to run this pipeline
1. Fork or clone this repo
2. Connect your github account to Travis CI
3. [Enable the repo at Travis CI](https://docs.travis-ci.com/user/getting-started/)
4. [Get your access key from seetest.io](https://docs.seetest.io/display/SEET/Obtaining+Access+Key+for+Remote+Testing) (you will have to [signup for seetest.io](https://seetest.io/signup))
5. [Set this access key as an environment variable at Travis CI](https://docs.travis-ci.com/user/environment-variables/). The variable name should be SEETEST_IO_ACCESS_KEY

#### Run the pipeline
1. Make any change, commit and push
2. You will see the build being triggered in Travis CI UI.
3. Access the seetest cloud (after having signed up to seetest.io) to [see the tests in action](https://docs.seetest.io/display/SEET/Viewing+Your+Automated+Appium+Tests).

Best Of Luck!
