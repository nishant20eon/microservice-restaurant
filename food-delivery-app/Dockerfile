# Stage 1: Build the Angular app
FROM node:16 AS build

WORKDIR /app

# Copy package files and install dependencies
COPY package*.json ./
RUN npm install

# Copy all source files
COPY . .

# Build the Angular app
RUN npm run build

# Stage 2: Serve the app with Nginx
FROM nginx:alpine

# Remove default Nginx static content
RUN rm -rf /usr/share/nginx/html/*

# Copy the built app to Nginx html directory
COPY --from=build /app/dist/food-delivery-app /usr/share/nginx/html

# Expose port 80
EXPOSE 80

# Correct CMD and fix typo ("daemon", not "dameon")
CMD ["nginx", "-g", "daemon off;"]
