package org.issue.jobnotenqueuedkotlin

import io.micrometer.core.annotation.Timed
import org.jobrunr.jobs.lambdas.JobRequest
import org.jobrunr.jobs.lambdas.JobRequestHandler
import org.jobrunr.scheduling.BackgroundJob
import org.jobrunr.scheduling.BackgroundJobRequest
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@Service
class MyJobRequestHandler: JobRequestHandler<MyJobRequest> {
    override fun run(jobRequest: MyJobRequest) {
        println("Hello, I'm executing a job with id: ${jobRequest.id}")
    }
}

class MyJobRequest(val id: UUID): JobRequest {
    override fun getJobRequestHandler(): Class<out JobRequestHandler<MyJobRequest>> {
        return MyJobRequestHandler::class.java
    }
}

@RestController
@RequestMapping("/hello")
class HelloWorld {
    @GetMapping
    @Timed("hello")
    fun helloWorld(): String {
        val id = UUID.randomUUID()
        val jobId = BackgroundJobRequest.enqueue(MyJobRequest(id))

        return "Hello, ${jobId}!"
    }
}