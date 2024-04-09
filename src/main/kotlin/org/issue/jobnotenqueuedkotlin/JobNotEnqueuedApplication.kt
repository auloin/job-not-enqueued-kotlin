package org.issue.jobnotenqueuedkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JobNotEnqueuedApplication

fun main(args: Array<String>) {
    runApplication<JobNotEnqueuedApplication>(*args)
}
