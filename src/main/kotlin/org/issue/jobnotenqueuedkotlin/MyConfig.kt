package org.issue.jobnotenqueuedkotlin

import org.jobrunr.exposed.transaction.ExposedTransactionAwareConnection
import org.jobrunr.exposed.transaction.ExposedTransactionAwareConnectionProvider
import org.jobrunr.spring.autoconfigure.storage.sql.SpringTransactionAwareConnectionProvider
import org.jobrunr.storage.sql.common.db.ConnectionProvider
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MyConfig {
    @Bean(name=["connectionProvider"])
    fun connectionProvider(): ConnectionProvider {
        return ExposedTransactionAwareConnectionProvider()
    }
}