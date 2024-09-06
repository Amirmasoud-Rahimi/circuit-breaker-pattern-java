package com.project.userservice.configuration;

import io.github.resilience4j.circuitbreaker.ResultRecordedAsFailureException;

import java.util.function.Predicate;

public class MyCustomRecordFailurePredicate implements Predicate<Throwable> {
    @Override
    public boolean test(Throwable throwable) {
        return false;
    }

    @Override
    public Predicate<Throwable> and(Predicate<? super Throwable> other) {
        return Predicate.super.and(other);
    }

    @Override
    public Predicate<Throwable> negate() {
        return Predicate.super.negate();
    }

    @Override
    public Predicate<Throwable> or(Predicate<? super Throwable> other) {
        return Predicate.super.or(other);
    }
}
