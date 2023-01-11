job('ejemplo2-job-DSL') {
  description('Job DSL de ejemplo para el curso de jenkins')
  scm {
    git('https://github.com/macloujulian/jenkins.job.parametrizado.git', 'main') { node ->
      node / gitConfigName('Juan9507')
      node / gitConfigEmail('juandavidnaranjo75@gmail.com')
    }
  }
  parameters {
  	stringParam('nombre', defaultValue = 'Juan', description = 'Parametro de cadena para el Job Booleano')
    choiceParam('planeta', ['Mercurio', 'Venus', 'Tierra', 'Marte', 'Jupiter', 'Saturno', 'Urano', 'Neptuno'])
    booleanParam('agente', false)
  }
  triggers {
    cron('H/7 * * * *')
    githubPush()
  }
  steps {
    shell("bash jobscript.sh")
  }
  publishers {
    mailer('jdrivera891@misena.edu.co', true, true)
  }
}
