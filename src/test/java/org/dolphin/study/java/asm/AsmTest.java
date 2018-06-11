package org.dolphin.study.java.asm;

<<<<<<< HEAD
import org.junit.Test;
import org.objectweb.asm.*;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

import java.io.*;
import java.util.List;

=======
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

import org.junit.Test;
import org.objectweb.asm.*;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

>>>>>>> ae7290b53f1ebbcb0d71ffe8ab60ab1d6e5e5f89
/**
 * Created by qi.sun on 2018/5/8.
 */
public class AsmTest {

    @Test public void testDeleteMethod() {
        try {
            InputStream stream = this.getClass().getClassLoader().getResourceAsStream("DfpConf.class");
            ClassReader classReader = new ClassReader(stream);
            System.out.print(classReader.getClassName());
            ClassNode classNode = new ClassNode();
            classReader.accept(classNode, 0);
            final List<MethodNode> methodNodes = classNode.methods;
            MethodNode toDeletemethodNode = null;
            for (MethodNode methodNode : methodNodes) {
                System.out.println(methodNode.name);
                if (methodNode.name == "compress") {
                    toDeletemethodNode = methodNode;
                }
            }
            classNode.methods.remove(toDeletemethodNode);
            final List<MethodNode> newMethodNodes = classNode.methods;
            for (MethodNode methodNode : newMethodNodes) {
                System.out.println(methodNode.name);
            }

            ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
            ClassVisitor classVisitor = new ClassVisitor(Opcodes.ASM5, classWriter) {

                public MethodVisitor visitMethod(int access, String name, String desc, String signature,
                                                 String[] exceptions) {
                    if ("contextStartedListener".equals(name)) {
                        return null;
                    }
                    return super.visitMethod(access, name, desc, signature, exceptions); //Not for null, retention
                }

            };
            classReader.accept(classVisitor, ClassReader.SKIP_DEBUG);
            File file = new File("/tmp/a.class");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(classWriter.toByteArray());
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

