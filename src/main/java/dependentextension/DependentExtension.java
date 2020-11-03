package dependentextension;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import net.minestom.server.extensions.Extension;

import javax.lang.model.element.Modifier;
import java.io.IOException;

public class DependentExtension extends Extension {

    public static long initializationTime = System.nanoTime();

    @Override
    public void initialize() {
        System.out.println("[Extension1] Extension1 was initialized at (in nanoseconds): "+ DependentExtension.initializationTime);
        System.out.println("[Extension1] Hi from the dependent extension!");
        System.out.println("[Extension1] Here's a HelloWorld class generated with Javapoet:");

        MethodSpec main = MethodSpec.methodBuilder("main")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .returns(void.class)
                .addParameter(String[].class, "args")
                .addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet!")
                .build();

        TypeSpec helloWorld = TypeSpec.classBuilder("HelloWorld")
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addMethod(main)
                .build();

        JavaFile javaFile = JavaFile.builder("com.example.helloworld", helloWorld)
                .build();

        try {
            javaFile.writeTo(System.out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void terminate() {

    }
}
