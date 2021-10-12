package ru.job4j;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.util.concurrent.TimeUnit;

@Warmup(iterations = 50)
@Measurement(iterations = 50)
@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Threads(1)
@Fork(1)
@Timeout(time = 5, timeUnit = TimeUnit.MINUTES)
public class PrintBenchmark {

    @Benchmark
    public void test1() throws Exception {
        // test logic
    }

    @Benchmark
    public void test2() throws Exception {
        // test logic
    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(PrintBenchmark.class.getSimpleName())
                .threads(1)
                .forks(1)
                .timeout(TimeValue.minutes(5))
                .build();
        new Runner(options).run();
    }
}
