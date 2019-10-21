package com.example.web.exampleweb.controller;

import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.client.JenkinsHttpClient;
import com.offbytwo.jenkins.model.Job;
import com.offbytwo.jenkins.model.JobWithDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.inf.util.User;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @program: example-cicd-springboot
 * @description:
 * @author: baijinlong
 * @create: 2019-09-25 19:00
 **/
@RequestMapping("/home")
@RestController
public class HomeController {


    @GetMapping("/index")
    public User index(){

        User user = new User();
        user.setName("lilei2");
        user.setAge(30);
        return user;
    }

    @PostMapping("/build")
    public void build(HttpServletRequest httpServletRequest, @RequestBody String body){

//        {"name":"example-springboot","display_name":"example-springboot","url":"job/example-springboot/","build":{"full_url":"http://localhost:8080/job/example-springboot/7/","number":7,"queue_id":7,"timestamp":1569761576042,"phase":"COMPLETED","status":"SUCCESS","url":"job/example-springboot/7/","scm":{"url":"https://github.com/Infaye/cicdexamplespringboot.git","branch":"origin/master","commit":"e530787911aba85fbc97cc89cdf4a12d7a09cebc","changes":[],"culprits":[]},"parameters":{"BUILD_NUMBER":"2019-09-29-01"},"log":"","notes":"","artifacts":{}}}
        System.out.println(httpServletRequest.getAuthType());
    }



    @GetMapping("/job")
    public Boolean create() throws URISyntaxException, IOException {
        JenkinsServer jenkinsServer = new JenkinsServer(new URI("http://localhost:8080/"), "baijinlong",
                "5568bjl414");
        List<String> li=new ArrayList<>();
        JobWithDetails jobs = jenkinsServer.getJob("example-springboot");
        jenkinsServer.createJob("jenkinsclientjob","<maven2-moduleset plugin=\"maven-plugin@3.4\">\n" +
                "  <actions/>\n" +
                "  <description>example-springboot ci/cd</description>\n" +
                "  <keepDependencies>false</keepDependencies>\n" +
                "  <properties>\n" +
                "    <com.coravy.hudson.plugins.github.GithubProjectProperty plugin=\"github@1.29.4\">\n" +
                "      <projectUrl>https://github.com/Infaye/cicdexamplespringboot.git/</projectUrl>\n" +
                "      <displayName></displayName>\n" +
                "    </com.coravy.hudson.plugins.github.GithubProjectProperty>\n" +
                "    <com.dabsquared.gitlabjenkins.connection.GitLabConnectionProperty plugin=\"gitlab-plugin@1.5.13\">\n" +
                "      <gitLabConnection></gitLabConnection>\n" +
                "    </com.dabsquared.gitlabjenkins.connection.GitLabConnectionProperty>\n" +
                "    <com.sonyericsson.rebuild.RebuildSettings plugin=\"rebuild@1.31\">\n" +
                "      <autoRebuild>false</autoRebuild>\n" +
                "      <rebuildDisabled>false</rebuildDisabled>\n" +
                "    </com.sonyericsson.rebuild.RebuildSettings>\n" +
                "  </properties>\n" +
                "  <scm class=\"hudson.plugins.git.GitSCM\" plugin=\"git@3.12.1\">\n" +
                "    <configVersion>2</configVersion>\n" +
                "    <userRemoteConfigs>\n" +
                "      <hudson.plugins.git.UserRemoteConfig>\n" +
                "        <url>https://github.com/Infaye/cicdexamplespringboot.git</url>\n" +
                "        <credentialsId>github-token</credentialsId>\n" +
                "      </hudson.plugins.git.UserRemoteConfig>\n" +
                "    </userRemoteConfigs>\n" +
                "    <branches>\n" +
                "      <hudson.plugins.git.BranchSpec>\n" +
                "        <name>*/master</name>\n" +
                "      </hudson.plugins.git.BranchSpec>\n" +
                "    </branches>\n" +
                "    <doGenerateSubmoduleConfigurations>false</doGenerateSubmoduleConfigurations>\n" +
                "    <submoduleCfg class=\"list\"/>\n" +
                "    <extensions/>\n" +
                "  </scm>\n" +
                "  <canRoam>true</canRoam>\n" +
                "  <disabled>false</disabled>\n" +
                "  <blockBuildWhenDownstreamBuilding>false</blockBuildWhenDownstreamBuilding>\n" +
                "  <blockBuildWhenUpstreamBuilding>false</blockBuildWhenUpstreamBuilding>\n" +
                "  <triggers>\n" +
                "    <com.cloudbees.jenkins.GitHubPushTrigger plugin=\"github@1.29.4\">\n" +
                "      <spec></spec>\n" +
                "    </com.cloudbees.jenkins.GitHubPushTrigger>\n" +
                "  </triggers>\n" +
                "  <concurrentBuild>false</concurrentBuild>\n" +
                "  <rootModule>\n" +
                "    <groupId>com.cicdexample.springboot</groupId>\n" +
                "    <artifactId>example-cicd-springboot</artifactId>\n" +
                "  </rootModule>\n" +
                "  <goals>clean package</goals>\n" +
                "  <mavenOpts>-Dmaven.test.skip=true</mavenOpts>\n" +
                "  <aggregatorStyleBuild>true</aggregatorStyleBuild>\n" +
                "  <incrementalBuild>false</incrementalBuild>\n" +
                "  <ignoreUpstremChanges>false</ignoreUpstremChanges>\n" +
                "  <ignoreUnsuccessfulUpstreams>false</ignoreUnsuccessfulUpstreams>\n" +
                "  <archivingDisabled>false</archivingDisabled>\n" +
                "  <siteArchivingDisabled>false</siteArchivingDisabled>\n" +
                "  <fingerprintingDisabled>false</fingerprintingDisabled>\n" +
                "  <resolveDependencies>false</resolveDependencies>\n" +
                "  <processPlugins>false</processPlugins>\n" +
                "  <mavenValidationLevel>-1</mavenValidationLevel>\n" +
                "  <runHeadless>false</runHeadless>\n" +
                "  <disableTriggerDownstreamProjects>false</disableTriggerDownstreamProjects>\n" +
                "  <blockTriggerWhenBuilding>true</blockTriggerWhenBuilding>\n" +
                "  <settings class=\"jenkins.mvn.DefaultSettingsProvider\"/>\n" +
                "  <globalSettings class=\"jenkins.mvn.DefaultGlobalSettingsProvider\"/>\n" +
                "  <reporters/>\n" +
                "  <publishers/>\n" +
                "  <buildWrappers/>\n" +
                "  <prebuilders/>\n" +
                "  <postbuilders/>\n" +
                "  <runPostStepsIfResult>\n" +
                "    <name>FAILURE</name>\n" +
                "    <ordinal>2</ordinal>\n" +
                "    <color>RED</color>\n" +
                "    <completeBuild>true</completeBuild>\n" +
                "  </runPostStepsIfResult>\n" +
                "</maven2-moduleset>",true);
        return true;
    }



}
