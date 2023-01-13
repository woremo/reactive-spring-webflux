package com.learnreactiveprogramming.service;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FluxAndMonoGeneratorServiceTest {

    FluxAndMonoGeneratorService fluxAndMonoGeneratorService =
            new FluxAndMonoGeneratorService();

    @Test
    void namesFlux() {

        var namesFlux = fluxAndMonoGeneratorService.namesFlux();

        StepVerifier.create(namesFlux)
//                .expectNext("alex", "ben", "chloe")
//                .expectNextCount(3)
                .expectNext("alex")
                .expectNextCount(2)
                .verifyComplete();
    }

    @Test
    void namesFlux_map(){

        int stringLength = 3;


        var namesFlux = fluxAndMonoGeneratorService
                .namesFlux_map(stringLength);

        StepVerifier.create(namesFlux)
                .expectNext("4-ALEX","5-CHLOE")
                .verifyComplete();

    }

    @Test
    void namesFlux_immutability(){


        var namesFlux = fluxAndMonoGeneratorService
                .namesFlux_immutability();

        StepVerifier.create(namesFlux)
                .expectNext("alex", "ben", "chloe")
                .verifyComplete();

    }

    @Test
    void namesFlux_flatMap(){

        int stringLength = 3;


        var namesFlux = fluxAndMonoGeneratorService
                .namesFlux_flatMap(stringLength);

        StepVerifier.create(namesFlux)
                .expectNext("A", "L", "E", "X", "C", "H", "L", "O", "E")
                .verifyComplete();

    }

    @Test
    void namesFlux_flatMap_async(){

        int stringLength = 3;


        var namesFlux = fluxAndMonoGeneratorService
                .namesFlux_flatMap_async(stringLength);

        StepVerifier.create(namesFlux)
//                .expectNext("A", "L", "E", "X", "C", "H", "L", "O", "E")
                .expectNextCount(9)
                .verifyComplete();

    }

    @Test
    void namesFlux_concatMap() {

        int stringLength = 3;


        var namesFlux = fluxAndMonoGeneratorService
                .namesFlux_concatMap(stringLength);

        StepVerifier.create(namesFlux)
                .expectNext("A", "L", "E", "X", "C", "H", "L", "O", "E")
//                .expectNextCount(9)
                .verifyComplete();
    }

    @Test
    void namesMono_flatMap() {

        int stringLength = 3;
        var value = fluxAndMonoGeneratorService
                .namesMono_flatMap(stringLength);

        StepVerifier.create(value)
                .expectNext(List.of("A","L","E","X"))
                .verifyComplete();
    }

    @Test
    void namesMono_flatMapMany() {

        int stringLength = 3;
        var value = fluxAndMonoGeneratorService
                .namesMono_flatMapMany(stringLength);

        StepVerifier.create(value)
                .expectNext("A","L","E","X")
                .verifyComplete();
    }

    @Test
    void namesFlux_transform() {
        int stringLength = 3;
        var namesFlux = fluxAndMonoGeneratorService
                .namesFlux_transform(stringLength);

        StepVerifier.create(namesFlux)
                .expectNext("A", "L", "E", "X", "C", "H", "L", "O", "E")
//                .expectNextCount(9)
                .verifyComplete();
    }

    @Test
    void namesFlux_transform_1() {
        int stringLength = 6;
        var namesFlux = fluxAndMonoGeneratorService
                .namesFlux_transform(stringLength);

        StepVerifier.create(namesFlux)
                .expectNext("default")
                .verifyComplete();
    }

    @Test
    void namesFlux_transform_switchIfEmpty() {
        int stringLength = 6;
        var namesFlux = fluxAndMonoGeneratorService
                .namesFlux_transform_switchIfEmpty(stringLength);

        StepVerifier.create(namesFlux)
                .expectNext("D","E","F","A","U","L","T")
                .verifyComplete();
    }

    @Test
    void explore_concat() {

        var concatFlux = fluxAndMonoGeneratorService
                .explore_concat();

        StepVerifier.create(concatFlux)
                .expectNext("A","B","C","D","E","F")
                .verifyComplete();

    }


    @Test
    void explore_concatwithMono() {

        var concatFlux = fluxAndMonoGeneratorService
                .explore_concatwith_mono();

        StepVerifier.create(concatFlux)
                .expectNext("A","B","C","D","E","F")
                .verifyComplete();

    }

    @Test
    void explore_merge() {

        var value = fluxAndMonoGeneratorService
                .explore_merge();

        StepVerifier.create(value)
                .expectNext("A","D","B","E","C","F")
                .verifyComplete();

    }


    @Test
    void explore_mergeSequential() {

        var mergeFlux = fluxAndMonoGeneratorService
                .explore_mergeSequential();

        StepVerifier.create(mergeFlux)
                .expectNext("A","B","C","D","E","F")
                .verifyComplete();

    }

    @Test
    void explore_zip() {
        var value = fluxAndMonoGeneratorService
                .explore_zip();

        StepVerifier.create(value)
                .expectNext("AD","BE","CF")
                .verifyComplete();

    }

    @Test
    void explore_zip_1() {

        var value = fluxAndMonoGeneratorService
                .explore_zip_1();

        StepVerifier.create(value)
                .expectNext("AD14","BE25","CF36")
                .verifyComplete();

    }
}