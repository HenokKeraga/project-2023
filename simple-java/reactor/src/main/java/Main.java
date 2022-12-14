public class Main {
    public static void main(String[] args) {
        Flux<String> flux = Flux.just("A");
        flux.map(s -> "foo" + s);
        flux.subscribe(System.out::println);
    }
}
