FROM node:18

WORKDIR /app

ENV PATH /app/node_modules/.bin:$PATH

COPY package.json ./

RUN npm install --force

COPY ./ ./


CMD ["npm", "run","serve"]
EXPOSE 8081