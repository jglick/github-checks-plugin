package io.jenkins.plugins.checks.api;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import static io.jenkins.plugins.checks.api.ChecksImageAssert.*;

class ChecksImageTest {
    final String ALT = "warnings-chart";
    final String IMAGE_URL = "https://ci.jenkins.io/job/Plugins/job/warnings-ng-plugin/job/master/";
    final String CAPTION = "charts generated by warning-ng-plugin";

    @Test
    void shouldConstructCorrectly() {
        final ChecksImage image = new ChecksImage(ALT, IMAGE_URL)
                .withCaption(CAPTION);

        assertThat(image)
                .hasAlt(ALT)
                .hasImageUrl(IMAGE_URL)
                .hasCaption(Optional.of(CAPTION));
    }

    @Test
    void shouldCopyConstructCorrectly() {
        final ChecksImage image = new ChecksImage(ALT, IMAGE_URL)
                .withCaption(CAPTION);
        final ChecksImage copied = new ChecksImage(image);

        assertThat(copied)
                .hasAlt(ALT)
                .hasImageUrl(IMAGE_URL)
                .hasCaption(Optional.of(CAPTION));
    }
}
