FROM node:20 AS build-stage

WORKDIR /app 
COPY  package*.json ./

RUN npm install

COPY . .


RUN chmod +x node_modules/.bin/vue-cli-service

RUN npx vue-cli-service build

RUN  npm run build 

# production stage 
FROM nginx:latest AS production-stage

COPY --from=build-stage /app/dist /usr/share/nginx/html

EXPOSE 80

CMD ["nginx","-g","daemon off;"]
