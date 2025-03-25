Here's a **complete README.md** that includes all the instructions to help you create and run your OSGi bundle using Apache Felix. You can copy and paste the following content into your `README.md` file:

---

# OSGi Bundle Setup Using Apache Felix

## **Prerequisites**
- **Java 8 or higher** installed on your system.
- **Apache Felix** distribution downloaded.
- **OSGi API (osgi-core.jar)** downloaded separately.

## **Folder Structure**

The project should have the following structure:

```
hello-osgi/                <-- Root project folder
│── src/                   <-- Source code directory
│   └── com/example/hello/  <-- Java package structure
│       ├── Activator.java  <-- OSGi Activator class
│       ├── HelloOSGi.java  <-- Sample class
│── META-INF/               <-- Manifest directory
│   └── MANIFEST.MF         <-- Manifest file
│── osgi-core.jar           <-- OSGi API dependency (download separately)
│── out/                    <-- Compiled classes (created after compilation)
│── helloosgi.jar           <-- Final OSGi bundle (created after packaging)
```

## **Step 1: Create Java Classes**
### **HelloOSGi.java**
Create the `HelloOSGi.java` class inside `src/com/example/hello/`:
```java
package com.example.hello;

public class HelloOSGi {
    public void sayHello() {
        System.out.println("Hello, OSGi!");
    }
}
```

### **Activator.java**
Create the `Activator.java` class inside `src/com/example/hello/`:
```java
package com.example.hello;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {
    @Override
    public void start(BundleContext context) {
        System.out.println("Hello OSGi Bundle Started!");
    }

    @Override
    public void stop(BundleContext context) {
        System.out.println("Hello OSGi Bundle Stopped!");
    }
}
```

## **Step 2: Create the `MANIFEST.MF` File**
Inside the `META-INF/` directory, create `MANIFEST.MF` with the following content:

```
Manifest-Version: 1.0
Bundle-Name: Hello OSGi
Bundle-SymbolicName: com.example.hello
Bundle-Version: 1.0.0
Bundle-Activator: com.example.hello.Activator
Import-Package: org.osgi.framework
```

## **Step 3: Download the `osgi-core.jar`**
Download the OSGi API JAR file (for compilation) from the Maven repository:

```sh
wget https://repo1.maven.org/maven2/org/osgi/osgi.core/8.0.0/osgi.core-8.0.0.jar -O osgi-core.jar
```

## **Step 4: Compile Java Files**
After placing all the files in the right directories, run the following command to compile the Java classes:

```sh
javac -d out -cp osgi-core.jar $(find src -name "*.java")
```

This will compile the source files and place the `.class` files in the `out/` directory.

## **Step 5: Package the Bundle**
Create the final OSGi bundle (`helloosgi.jar`) by running:

```sh
jar cfm helloosgi.jar META-INF/MANIFEST.MF -C out .
```

The `helloosgi.jar` bundle is now ready.

## **Step 6: Set Up Apache Felix**
1. Download Apache Felix from the [official site](https://felix.apache.org/downloads.cgi).
2. Extract it and navigate to the `bin/` folder.

## **Step 7: Start Apache Felix**
In the `bin/` directory of Felix, run:

```sh
java -jar felix.jar
```

This will start the Apache Felix framework and bring you to the **Felix Gogo Shell**.

## **Step 8: Install Your OSGi Bundle**
1. **Move `helloosgi.jar`** to the Felix directory (`org.apache.felix.main.distribution-7.0.5/`).
2. In the Felix shell, run:

```sh
install file:helloosgi.jar
```

This will install your bundle and return an **ID** for the bundle.

## **Step 9: Start the Bundle**
After installing the bundle, start it by running:

```sh
start <bundle_id>
```

Replace `<bundle_id>` with the actual ID (e.g., `3`).

## **Step 10: Verify Output**
Once the bundle starts, you should see this output in the Felix console:

```
Hello OSGi Bundle Started!
```

If you want to stop the bundle, run:

```sh
stop <bundle_id>
```

## **Step 11: List All Bundles**
To see a list of all installed bundles and their IDs, run:

```sh
lb
```

This will show you a list of bundles along with their state and ID.

## **Step 12: Uninstall the Bundle (Optional)**
To uninstall the bundle, run:

```sh
uninstall <bundle_id>
```

---

## **Troubleshooting**
- **"File Not Found" Error**: Ensure `helloosgi.jar` is in the same directory where you are running the `install` command.
- **Empty JAR File**: If `osgi-core.jar` is empty, download it again from the Maven repository.

---

### **Next Steps**
- Explore **OSGi services** to enable communication between bundles.
- Learn more about **OSGi declarative services** for better bundle management.

---
