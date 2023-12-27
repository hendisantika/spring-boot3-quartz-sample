package com.hendisantika.quartzsample.job;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hendisantika.quartzsample.dto.JobDTO;
import com.hendisantika.quartzsample.service.MailService;
import io.micrometer.common.lang.NonNullApi;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot3-quartz-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/27/23
 * Time: 08:20
 * To change this template use File | Settings | File Templates.
 */
@Component
@NonNullApi
@Slf4j
@Setter
@DisallowConcurrentExecution
public class Job extends QuartzJobBean {

    private MailService mailService;

    @Autowired
    public void autowire(final MailService mailService) {
        this.mailService = mailService;
    }

    @Override
    public void executeInternal(final JobExecutionContext context) {
        log.info("Job execute {}", context.getJobDetail().getKey().getName());
        JobDTO jobDTO = null;
        try {
            jobDTO =
                    new ObjectMapper()
                            .readValue(context.getMergedJobDataMap().getString("jobDTO"), JobDTO.class);
        } catch (JsonProcessingException e) {
            log.info(e.toString());
        }
        mailService.send(jobDTO.getFrom(), jobDTO.getTo(), jobDTO.getSubject(), jobDTO.getBody());
        if (false) {
            this.unScheduleJob(context);
        }
    }

    private void unScheduleJob(JobExecutionContext context) {
        try {
            log.info("Job unscheduled {}", context.getTrigger().getKey());
            context.getScheduler().unscheduleJob(context.getTrigger().getKey());
        } catch (SchedulerException e) {
            log.error("Error while unscheduled job", e);
        }
    }
}
