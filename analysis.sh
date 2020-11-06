#!/bin/bash

export SONAR_TOKEN=f97c3b84760a5ee0693d3eabf995194b4e5bc68a
mvn clean verify site spotbugs:spotbugs com.github.meixuesong:merge-cpd-pmd-report-maven-plugin:1.0:merge sonar:sonar
