// package in.vvm.FileOperations.config;

// import in.vvm.FileOperations.entity.Pincode;
// import lombok.RequiredArgsConstructor;
// import org.springframework.batch.core.Job;
// import org.springframework.batch.core.Step;
// import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
// import org.springframework.batch.core.job.builder.JobBuilder;
// import org.springframework.batch.core.repository.JobRepository;
// import org.springframework.batch.core.step.builder.StepBuilder;
// import org.springframework.batch.extensions.excel.RowMapper;
// import org.springframework.batch.extensions.excel.mapping.BeanWrapperRowMapper;
// import org.springframework.batch.extensions.excel.poi.PoiItemReader;
// import org.springframework.batch.item.ItemProcessor;
// import org.springframework.batch.item.ItemWriter;
// import org.springframework.batch.item.database.builder.JpaItemWriterBuilder;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.core.env.Environment;
// import org.springframework.core.io.ClassPathResource;
// import org.springframework.jdbc.datasource.DataSourceTransactionManager;

// @Configuration
// @EnableBatchProcessing
// @RequiredArgsConstructor
// public class UploadBatchConfig {

//     @Bean
//     public Job job(JobRepository jobRepository, CompletionNotifierListener listener, Step step){
//         return new JobBuilder("job",jobRepository)
//                 .listener(listener)
//                 .start(step)
//                 .build();
//     }

//     @Bean
//     public Step step(JobRepository jobRepository, DataSourceTransactionManager transactionManager){
//         return new StepBuilder("step1",jobRepository)
//                 .chunk(20,transactionManager)
//                 .build();
//     }
//     @Bean
//     public PoiItemReader<Pincode> excelReader(Environment environment) {
//         PoiItemReader<Pincode> reader = new PoiItemReader<>();
//         reader.setResource(new ClassPathResource(environment.getRequiredProperty("")));
//         reader.setRowMapper(excelRowMapper());
//         return reader;
//     }

//     private RowMapper<Pincode> excelRowMapper(){
//         BeanWrapperRowMapper<Pincode> rowMapper = new BeanWrapperRowMapper<>();
//         rowMapper.setTargetType(Pincode.class);
//         return rowMapper;
//     }

//     @Bean
//     public ItemProcessor<Pincode,Pincode> dataProcessor(){
//         return new ExcelProcessor();
//     }

//     @Bean
//     public ItemWriter<Pincode> dbWriter(){
//         return new JpaItemWriterBuilder<Pincode>()
//                 .build();
//     }
// }