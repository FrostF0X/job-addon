### Example
```groovy
    node {
        stage('Build'){
            print 'test'
        }
        jobAddon(name:'Deploy staging', id:'deploy')
    }
```

Also you have to define job **deploy**