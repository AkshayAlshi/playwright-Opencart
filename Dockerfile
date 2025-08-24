FROM mcr.microsoft.com/playwright:jammy
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npx playwright install --with-deps
CMD ["npx", "playwright", "test"]
