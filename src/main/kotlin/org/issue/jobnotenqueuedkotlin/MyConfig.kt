package org.issue.jobnotenqueuedkotlin

import org.jetbrains.exposed.spring.autoconfigure.ExposedAutoConfiguration
import org.jobrunr.exposed.transaction.sql.ExposedTransactionAwareConnectionProvider
import org.jobrunr.storage.sql.common.db.ConnectionProvider
import org.springframework.boot.autoconfigure.ImportAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@ImportAutoConfiguration(
    value = [ExposedAutoConfiguration::class],
    exclude = [DataSourceTransactionManagerAutoConfiguration::class]
)
class MyConfig {
//    @Bean(name=["connectionProvider"])
//    fun connectionProvider(): ConnectionProvider {
//        return ExposedTransactionAwareConnectionProvider()
//    }
}