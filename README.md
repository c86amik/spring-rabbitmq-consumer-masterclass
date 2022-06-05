# spring-rabbitmq-consumer-masterclass

## A good understanding of the usage of RabbitMQ Subscriber/Consumer using Spring Boot

### Software Required
* [Java 1.8](https://www.oracle.com/in/java/technologies/javase/javase8-archive-downloads.html)
* [Spring tool Suite](https://spring.io/tools) or [Eclipse](https://www.eclipse.org/downloads/packages/)
* [Apache Maven](https://maven.apache.org/download.cgi)
* [Git Bash](https://gramfile.com/git-bash-download/)
* [Erlang](https://www.erlang.org/downloads)
* [RabbitMQ](https://www.rabbitmq.com/install-windows.html#installer)


### Steps to install Erlang
* <strong>N.B. - If already installed, don't reinstall</strong>
* Go to Erlang Download Page as mentioned above
* Click on the OTP 24.0 Windows 32-bit/64-bit Binary File (Based on the bit of your operating system click the desired link)
* It will download the exe file
* Double click on the exe file
* It will start installing on your local machine in default (Program Files) folder location
* After successful installation set the PATH variables
* Open the Environment Variables from Advance System Settings
* Click on Add
* Set the Name as `ERLANG_HOME`
* Set the Value as `C:\Program Files\erl-24.0`
* After that modify the `PATH` variable and put the value as `%ERLANG_HOME%\bin\`
* To verify open `cmd` and run the command as `erl -version`. It will output the version of installed Erlang in your local machine

### Steps to install RabbitMQ
* <strong>N.B. - If already installed, don't reinstall</strong>
* Download the .exe file from the Page as mentioned above in the [Software Required](https://github.com/c86amik/spring-rabbitmq-consumer-masterclass#software-required) section
* Install the exe file in your local machine
* The above installation will also install the RabbitMQ Command Prompt
* Open the RabbitMQ Command Prompt
* Run the command as `rabbitmq-server start`. It will start the RabbitMQ Server
* To access the RabbitMQ Management Console install one RabbitMQ plugin by running a command `rabbitmq-plugins.bat enable rabbitmq_management`
* After that open a browser and run `localhost:15672`
* It will opt to provide Username and Password
* By default the Username and Password both are <strong>`guest`</strong>


### Steps to clone and run the application
* Install [Erlang](https://github.com/c86amik/spring-rabbitmq-consumer-masterclass#steps-to-install-erlang)
* Install [RabbitMQ](https://github.com/c86amik/spring-rabbitmq-consumer-masterclass#steps-to-install-rabbitmq)
* Open Git Bash or even you can open Command Prompt (if you are using Windows) or Terminal (if you are using MAC) in your machine
* Clone the application from github.com as   
<code>git clone https://github.com/c86amik/spring-rabbitmq-consumer-masterclass.git</code>
* Open either <strong>STS</strong> or <strong>Eclipse</strong> and import the application as <strong>Maven</strong> project
* After the application got successfully imported in either <strong>STS</strong> or <strong>Eclipse</strong>
* Right Click on the application, select the <strong>Run As</strong> option, and then select <strong>Spring Boot App</strong>
* The application will start in the port <strong>7114</strong>

### Testing
* Once the application started it will consume all the 5 messages in the Queue as published earlier and will proint the data in the console