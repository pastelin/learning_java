package challenge_interface;

enum Geometry {
    LINE, POLYGON, POINT
}

enum Color {BLACK, WHITE, RED, GREEN, BLUE, YELLOW, ORANGE, PURPLE, GRAY}

enum PointMarker {
    CIRCLE, SQUARE, TRIANGLE, STAR, PUSH_PIN
}

enum LineMarker {
    SOLID, DASHED, DOTTED
}

public interface Mappable {

    String JSON_PROPERTY = """
            "properties": {%s}
            """;

    String getLabel();

    Geometry getShape();

    String getMarker();

    default String toJSON() {
        return """
                "type": "%s", "label": "%s", "marker": "%s" """
                .formatted(getShape(), getLabel(), getMarker());
    }

    static void mapIt(Mappable mappable) {
        System.out.println(JSON_PROPERTY.formatted(mappable.toJSON()));
    }
}
