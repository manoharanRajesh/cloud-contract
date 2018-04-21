#!groovy

node() {
    stage('Checkout'){
        checkout scm
    }
    stage ('build'){
        //build
    }

    parallel 'integration-tests':{
       // node('mvn-3.3'){ ... }
    }, 'functional-tests':{
       //  node('selenium'){ ... }
    }

    stage 'deployment'
    input 'Do you approve deployment?'
    node{
        // deploy the things
    }

}
