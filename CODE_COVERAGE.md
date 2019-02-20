# Code Coverage Report generation

To generate the code coverage report, execute the following command:
> mvn clean verify jacoco:report

This will generate code coverage report in each of the modules. In order to view the same, open the following file in your browser.
> target/site/jacoco/index.html 

Please note that the above folder is created under each of the modules. For example:
* adapter/target/site/jacoco/index.html 
* business-delegate/target/site/jacoco/index.html 



# [代码覆盖率报告生成](#code-coverage-report-generation)

要生成代码覆盖率报告，请执行以下命令：

> mvn clean verify jacoco:report

这将在每个模块中生成代码覆盖率报告。要查看相同内容，请在浏览器中打开以下文件。

> target/site/jacoco/index.html 

请注意，上面的文件夹是在每个模块下创建的。例如：

- adapter/target/site/jacoco/index.html 
- business-delegate/target/site/jacoco/index.html 