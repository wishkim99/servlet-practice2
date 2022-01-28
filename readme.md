# servlet-practices

### 1. Maven War project 만들기
1.	maven project 생성:  packaging =>  war
2.	project 선택(오른쪽메뉴)-> java EE Tools -> generate Deployment Descriptor Stub(web.xml)
3.	web.xml 에서 xmlns="http://JAVA.sun.com/xml/ns/javaee" 수정
4.	pom.xml 설정(helloweb 참고)
<build>
		<finalName>guestbook01</finalName>
		<sourceDirectory>${project.basedir}/src/main/java</sourceDirectory>
		<resources>
			<resource>
				<directory>${project.basedir}/src/main/resources</directory>
				<excludes>
					<exclude>**/*.java</exclude>
				</excludes>
			</resource>
		</resources>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.8.0</version>
				<configuration>
					<source>11</source>
					<target>11</target>
				</configuration>
			</plugin>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-resources-plugin</artifactId>
				<version>3.2.0</version>
				<configuration>
					<encoding>UTF-8</encoding>
				</configuration>
			</plugin>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-war-plugin</artifactId>
				<version>3.2.1</version>
				<configuration>
					<warSourceDirectory>${project.basedir}/src/main/webapp</warSourceDirectory>
					<failOnMissingWebXml>true</failOnMissingWebXml>
				</configuration>
			</plugin>
		</plugins>
	</build>	
</project>


### 2. applications
1. model1: model + jsp(controller,view)
 
	-emaillist01
	-guestbook01

2. model2: mvc, Model + View(jsp) + Controller(servlet)

	-emaillist02
	-guestbook02
	3.
mysite02