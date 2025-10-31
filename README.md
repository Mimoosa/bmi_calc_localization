## Jenkins and Docker Deployment

This project uses Jenkins to build the JavaFX BMI calculator, create a fat JAR, build a Docker image, and publish it to Docker Hub.

### Build and Publish

- Jenkins builds the Maven project.
- A fat JAR is created using `maven-shade-plugin`.
- The Docker image is built from the provided `Dockerfile`.
- The image is pushed to Docker Hub: `mimoosamona/bmi_calculator:latest`.

### Run GUI App

To run the GUI application:

```bash
docker run \
  -e DISPLAY=:0 \
  -v /mnt/wslg:/mnt/wslg \
  -v /tmp/.X11-unix:/tmp/.X11-unix \
  -e WAYLAND_DISPLAY \
  -e XDG_RUNTIME_DIR \
  -e PULSE_SERVER \
  -v /etc/machine-id:/etc/machine-id \
  -v /var/run/dbus:/var/run/dbus \
  mimoosamona/bmi_calculator:latest

<<img width="1860" height="863" alt="Screenshot 2025-10-30 120451" src="https://github.com/user-attachments/assets/fab9f421-09c3-4ae9-9233-0c6d60cd7b15" />

The application supports multiple languages through resource bundles:
<img width="326" height="633" alt="image" src="https://github.com/user-attachments/assets/c0671b09-9d4f-4933-935f-9034686e1e5f" />
img width="332" height="629" alt="Screenshot 2025-10-31 142433" src="https://github.com/user-attachments/assets/3ad5f63f-e0a7-4459-aae8-74d44b301eae" />
