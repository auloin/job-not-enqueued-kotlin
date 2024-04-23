package org.issue.jobnotenqueuedkotlin

import org.jobrunr.exposed.transaction.sql.ExposedTransactionAwareConnectionProvider
import org.jobrunr.exposed.transaction.sql.ExposedTransactionAwareJobEnqueuedMulticastMessagePublisher
import org.jobrunr.spring.autoconfigure.storage.sql.SpringTransactionAwareJobEnqueuedMulticastMessagePublisher
import org.jobrunr.storage.StorageProvider
import org.jobrunr.storage.sql.SqlStorageProvider
import org.jobrunr.storage.sql.common.db.ConnectionProvider
import org.jobrunr.utils.StringUtils
import org.jobrunr.utils.multicast.JobEnqueuedMessagePublisher
import org.jobrunr.utils.multicast.MulticastMessagePublisher
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.net.URI

@Configuration
class MyConfig {
    @Bean(name=["connectionProvider"])
    fun connectionProvider(): ConnectionProvider {
        return ExposedTransactionAwareConnectionProvider()
    }

    @Bean
    fun jobEnqueuedMessagePublisher(storageProvider: StorageProvider?): JobEnqueuedMessagePublisher {
        val multicastMessagePublisher = MulticastMessagePublisher(StringUtils.toURI("udp://239.076.159.181:8379"))
        if (storageProvider is SqlStorageProvider) {
            return ExposedTransactionAwareJobEnqueuedMulticastMessagePublisher(multicastMessagePublisher)
        }
        return multicastMessagePublisher
    }
}