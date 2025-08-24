FROM ubuntu:22.04
RUN apt-get update && apt-get install -y curl gnupg
RUN curl -fsSL https://deb.nodesource.com/setup_20.x | bash - \
    && apt-get install -y nodejs
RUN npm install -g playwright@latest
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
CMD ["npx", "playwright", "test"]
